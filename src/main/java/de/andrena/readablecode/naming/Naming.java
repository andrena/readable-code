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
		public void method() {
			/** six chunks, expressive but not recallable */
			String propertySubStringAfterSecondDot = null; // do some research how this one was used
			/** one chunk, less expressive but recallable */
			String suffix = null; 
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
