package com.ignek.SpringAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {
	@Autowired
	@Qualifier("snapdragon")
	MobileProcessor mobileProcessor;
	
		public MobileProcessor getMobileProcessor() {
		return mobileProcessor;
	}

	public void setMobileProcessor(MobileProcessor mobileProcessor) {
		this.mobileProcessor = mobileProcessor;
	}

		public void config() {
			System.out.println("Octa core, 4 gb ram, 12mp camera");
			mobileProcessor.process();
		}
}
  