package com.yuan.fest.latte.ec.icon;

import com.joanzapata.iconify.Icon;

public enum EcIcons implements Icon {
    icon_scan('\ue640'),
    icon_message('\ue602'),
    icon_find('\ue726'),
    icon_book_city('\ue620'),
    icon_mine('\ue616'),
    icon_bookshelf('\ue610'),
    icon_search('\ue620'),
    icon_more('\ue603'),
    icon_manager('\ue733'),
    icon_more_s('\ue604'),
    icon_set('\ue611'),
    icon_cancel('\ue65a'),
    icon_confirm('\ue615');


    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
