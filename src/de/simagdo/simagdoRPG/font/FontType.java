package de.simagdo.simagdoRPG.font;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TextLoader;
import de.simagdo.simagdoRPG.utils.MyFile;

public enum FontType {

    TEST(new MyFile(""), new MyFile(""), new GillCalculator());

    private TextLoader loader;
    private FontVariablesCalculator calculator;

    private FontType(MyFile textureAtlas, MyFile fontFile, FontVariablesCalculator calculator) {

    }

}
