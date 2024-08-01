package com.finallite.app.moverecords

import com.finallite.app.formatRecordInformation
import com.finallite.app.settings.SettingsMapper
import com.finallite.data.database.Record

fun recordToMoveRecordsItem(settingsMapper: SettingsMapper, item: Record): MoveRecordsItem {
	return MoveRecordsItem(
		item.id,
		item.name,
		formatRecordInformation(settingsMapper, item.format, item.sampleRate, item.size)
	)
}

fun recordsToMoveRecordsItems(settingsMapper: SettingsMapper, items: List<Record>): List<MoveRecordsItem> {
	return items.map { recordToMoveRecordsItem(settingsMapper, it) }
}
