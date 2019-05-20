package com.processor;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MP4ToMP3Converter {

    final static Logger logger = Logger.getLogger(MP4ToMP3Converter.class);

    public static void main(String[] args) {
        String mp4File = "C:\\temp\\SampleVideo_1280x720_1mb.mp4";
        String mp3File = "C:\\temp\\MP3Output.mp3";
        convertMp4ToMp3(mp4File, mp3File);

    }

    public static void convertMp4ToMp3(String mp4File, String mp3File){
        logger.info("Converting file " + mp4File + " to " + mp3File);
        String line;
        String cmd1 = "C:\\temp\\ffmpeg-20181003-ebc3d04-win64-static\\bin\\ffmpeg";
        String arg1 =  "-i";
        String arg2 = mp4File;
        String arg3 = mp3File;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(cmd1, arg1, arg2, arg3);
        try{
            Process process = processBuilder.start();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
            logger.info("Video converted successfully!");
            //System.out.println("Video converted successfully!");
            in.close();
        } catch (Exception e) {
            logger.error("Error in convertMp4ToMp3");
            e.printStackTrace();
        }
    }
}
