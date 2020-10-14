package com.vivek.regexValidator.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceMeValidator {

	@Value(value = "${regex.timeout.value}")
	String time;


	public ResponseEntity<ValidationResponse> checkAndFind(ValidationRequest vrq){
		ValidationResponse vrn=new ValidationResponse();
		vrn.setError(true);
		vrn.setMatch(null);
		
		ExecutorService es=Executors.newSingleThreadExecutor();
	//	System.out.println(Integer.valueOf(time));
		try {
			return 
					es.submit(()-> {
				try {

					Pattern pattern = Pattern.compile(vrq.getRegex()); 

					Matcher m = pattern.matcher(vrq.getRequestBody()); 
					if(m.find())
						vrn.setMatch("Pattern "+m.group()+" found from " + m.start() + 
							" to " + (m.end()-1) +", total matches are "+m.results().count());
					else {
			//			vrn.setMatch(null);
			//			System.out.println("regex= "+vrq.getRegex()+" pattern= "+vrq.getRequestBody()+" not found");
					}
					vrn.setError(false);
					return ResponseEntity.ok(vrn);
				}catch(Throwable th) {
					es.shutdownNow();
					return ResponseEntity.badRequest().body(vrn);
				}
			}).get(Integer.valueOf(time), TimeUnit.MILLISECONDS);
		} 
		catch(Exception e) {
			es.shutdownNow();
			return ResponseEntity.badRequest().body(vrn);
		}
		
	}

}
