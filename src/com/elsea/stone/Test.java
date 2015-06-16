package com.elsea.stone;

public class Test
{

	public static void main(String[] args)
	{
		
		PropertyPoolTemplate p = new PropertyPoolTemplate();
		
//		p
//			.group("settings")
//				.group("behavior")
//					.property("ProgramLaunchAction",  "ViewModern")
//					.property("ScreenshotEndAction",  "PictureView")
//					.property("ScreenshotCopyAction", "Copy")
//				.end()
//				.group("paths")
//					.property("PictureSave", "/pics")
//				.end()
//			.end()
//			.view()
//		;
		
		
		p
			.group("test")
				.group("baby")
			.showStack();
		
	}
	
}