package com.prey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;

import com.prey.actions.HttpDataService;
import com.prey.net.PreyHttpResponse;
import com.prey.net.PreyRestHttpClient;
import com.prey.net.PreyWebServices;
import com.prey.net.http.EntityFile;

public class PreyEmail {

	
	public static void sendDataMail(Context ctx, HttpDataService data) {
		try {
			if (data!=null ){
				List<EntityFile> entityFiles = data.getEntityFiles();
				if(entityFiles!=null&&entityFiles.size()>=0){ 
					String url = PreyWebServices.getFileUrlJson(ctx);
					PreyLogger.i("URL:" + url);

					Map<String, String> parameters = new HashMap<String, String>();
					PreyConfig preyConfig = PreyConfig.getPreyConfig(ctx);
					PreyHttpResponse preyHttpResponse = null;
					preyHttpResponse = PreyRestHttpClient.getInstance(ctx).postAutentication(url, parameters, preyConfig, entityFiles);
			
					PreyLogger.i("status line:" + preyHttpResponse.getStatusLine());
				}
			}
		} catch (Exception e) {
			PreyLogger.e("Error causa:" + e.getMessage() + e.getMessage(), e);
		}
	}
}
