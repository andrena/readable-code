package de.andrena.readablecode.naming;

import java.util.List;

public class Naming {
	public static class FromSpringData {
		/** two chunks (find id) = ok*/
		public Entry findById(long messageId) {
			return null;
		}

		/** four chunks (find id & lang) = ok*/
		public Entry findByIdAndLang(long messageId, String language) {
			return null;
		}

		/** six chunks (find id & lang & collection) = not recallable*/
		public Entry findByIdAndLangAndCollection(long messageId, String language,String collection) {
			return null;
		}

		/** twelve chunks (find id not & lang & collection & category and date before) = not readable*/
		public Entry findByIdNotAndLangAndCollectionAndCategoryInAndDateBefore(long messageId, String language, String collection, List<String> categories, long page, long size) {
			return null;
		}
	}
	
	public static class InTemporaryVariables {
		
		public String getViolationElement1(String propertyPath) {
	        String[] splitProperty = propertyPath.split("\\.", 3);
	        /** precise but not recallable */
	        String propertySubStringAfterSecondDot = splitProperty[splitProperty.length - 1];
	        return propertySubStringAfterSecondDot;
	    }

		public String getViolationElement2(String propertyPath) {
			/** without variables, describing the whole process */
			return new StringExtractor(propertyPath)
				.consumeUntil('.')
				.consumeUntil('.')
				.remainder();
	    }
	}
	
	public static class StringExtractor {

		private String remainder;

		public StringExtractor(String remainder) {
			this.remainder = remainder;
		}

		public StringExtractor consumeUntil(char c) {
			int pos = remainder.indexOf(c); 
			remainder = remainder.substring(pos+1);
			return this;
		}

		public String remainder() {
			return remainder;
		}
		
	}
	
	public static class ProxySelectorAdapter {
	}
	
	/** 7-8 chunks = not readable*/
	public static class RetryOnceProxyAddressToProxySelectorAdapter extends ProxySelectorAdapter {
		
	}
	
	/** 3 chunks = ok */
	public static class SingleRetryAdapter extends ProxySelectorAdapter {
	}
}
