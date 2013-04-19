package io.trigger.forge.android.modules.share;

import io.trigger.forge.android.core.ForgeApp;
import io.trigger.forge.android.core.ForgeIntentResultHandler;
import io.trigger.forge.android.core.ForgeParam;
import io.trigger.forge.android.core.ForgeTask;
import android.content.Intent;

public class API {
	public static void text(final ForgeTask task, @ForgeParam("sharedText") final String sharedText, @ForgeParam("sharedSubject") final String sharedSubject) {
		if (sharedText.length() == 0) {
			task.error("No text entered");
			return;
		}
		task.performUI(new Runnable() {
			public void run() {
				
	            Intent sharingIntent = new Intent ( Intent.ACTION_SEND );
	            sharingIntent.putExtra ( Intent.EXTRA_TEXT, sharedText );
	            
	            if (sharedSubject.length() > 0) {
	            	sharingIntent.putExtra ( Intent.EXTRA_SUBJECT, sharedSubject );
	            }
	            
	            sharingIntent.setType ( "text/plain" );
	            
	            ForgeApp.intentWithHandler ( sharingIntent, new ForgeIntentResultHandler() {
					
					@Override
					public void result(int arg0, int arg1, Intent arg2) {
						task.success();
					}
				});
	        }
		});
	}
}
