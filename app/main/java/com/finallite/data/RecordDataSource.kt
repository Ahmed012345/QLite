package com.finallite.data

import com.finallite.data.database.LocalRepository
import com.finallite.data.database.Record
import com.finallite.data.Prefs

class RecordDataSource(
    private val localRepository: LocalRepository,
    private val prefs: Prefs,
) {

    private var activeRecord: Record? = null
    var recordingRecord: Record? = null

    fun getActiveRecord(): Record? {
        synchronized(this) {
            val id = prefs.activeRecord.toInt()
            return if (activeRecord != null && activeRecord?.id == id) {
                activeRecord
            } else if (id >= 0) {
                activeRecord = localRepository.getRecord(id)
                activeRecord
            } else {
                null
            }
        }
    }

    fun clearActiveRecord() {
        activeRecord = null
    }
}
