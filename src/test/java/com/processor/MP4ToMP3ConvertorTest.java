package com.processor;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

public class MP4ToMP3ConvertorTest {

    @Test
    public void convertMp4ToMp3(){
        String mp4File = "C:\\temp\\SampleVideo_1280x720_1mb.mp4";
        String mp3File = "C:\\temp\\MP3Output.mp3";
        File file = new File(mp3File);
        if (file.exists()) file.delete();
        MP4ToMP3Converter.convertMp4ToMp3(mp4File, mp3File);
        assertTrue(file.exists());
    }
}
