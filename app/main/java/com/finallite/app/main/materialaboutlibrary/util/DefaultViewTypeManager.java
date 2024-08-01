package com.finallite.app.main.materialaboutlibrary.util;

import android.content.Context;
import android.view.View;

import com.finallite.app.main.materialaboutlibrary.holders.MaterialAboutItemViewHolder;
import com.finallite.app.main.materialaboutlibrary.items.MaterialAboutActionItem;
import com.finallite.app.main.materialaboutlibrary.items.MaterialAboutItem;
import com.finallite.app.main.materialaboutlibrary.items.MaterialAboutTitleItem;

public class DefaultViewTypeManager extends ViewTypeManager {

    public static final class ItemType {
        public static final int ACTION_ITEM = ViewTypeManager.ItemType.ACTION_ITEM;
        public static final int TITLE_ITEM = ViewTypeManager.ItemType.TITLE_ITEM;
    }

    public static final class ItemLayout {
        public static final int ACTION_LAYOUT = ViewTypeManager.ItemLayout.ACTION_LAYOUT;
        public static final int TITLE_LAYOUT = ViewTypeManager.ItemLayout.TITLE_LAYOUT;
    }

    public int getLayout(int itemType) {
        switch (itemType) {
            case ItemType.ACTION_ITEM:
                return ItemLayout.ACTION_LAYOUT;
            case ItemType.TITLE_ITEM:
                return ItemLayout.TITLE_LAYOUT;
            default:
                return -1;
        }
    }

    public MaterialAboutItemViewHolder getViewHolder(int itemType, View view) {
        switch (itemType) {
            case ItemType.ACTION_ITEM:
                return MaterialAboutActionItem.getViewHolder(view);
            case ItemType.TITLE_ITEM:
                return MaterialAboutTitleItem.getViewHolder(view);
            default:
                return null;
        }
    }

    public void setupItem(int itemType, MaterialAboutItemViewHolder holder, MaterialAboutItem item, Context context) {
        switch (itemType) {
            case ItemType.ACTION_ITEM:
                MaterialAboutActionItem.setupItem((MaterialAboutActionItem.MaterialAboutActionItemViewHolder) holder, (MaterialAboutActionItem) item, context);
                break;
            case ItemType.TITLE_ITEM:
                MaterialAboutTitleItem.setupItem((MaterialAboutTitleItem.MaterialAboutTitleItemViewHolder) holder, (MaterialAboutTitleItem) item, context);
                break;
        }
    }
}
