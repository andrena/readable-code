package de.andrena.readablecode.part_1a_naming;

import java.util.List;

public class Naming {
	public static class FromSpringData {
		/** 
		 * findBy       = 0 (trivial)
		 * id           = +1
		 * total chunks = 1 (ok)
		 */
		public Entry findById(long id) {
			return null;
		}
		
        /**
		 * findBy       = 0 (trivial)
		 * operator &   = +1
		 * id           = +1
		 * language     = +1
		 * total chunks = 3 (ok)
		 */
		public Entry findByIdAndLang(long id, String language) {
			return null;
		}

        /**
		 * findBy       = 0 (trivial)
		 * operator &   = +1
		 * id           = +1
		 * lang         = +1
		 * collection   = +1
		 * total chunks = 4 (ok)
		 */
		public Entry findByIdAndLangAndCollection(long id, String language,String collection) {
			return null;
		}

        /**
		 * findBy       = 0 (trivial)
		 * operator &   = +1
		 * !id          = +2
		 * lang         = +1
		 * collection   = +1
		 * total chunks = 5 (not recallable)
		 */
		public Entry findByIdNotAndLangAndCollection(long id, String language,String collection) {
			return null;
		}

        /**
		 * findBy       = 0 (trivial)
		 * operator &   = +1
		 * !id          = +2
		 * lang         = +1
		 * collection   = +1
		 * category     = +1
		 * date before  = +2
		 * total chunks = 8 (really not recallable)
		 */
		public Entry findByIdNotAndLangAndCollectionAndCategoryInAndDateBefore(long id, String language, String collection, List<String> categories, long page, long size) {
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
