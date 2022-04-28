package de.andrena.readablecode.naming;

import java.util.List;

public interface FromSpringData {
	/** 
	 * findBy       = 0 (trivial)
	 * id           = +1
	 * total chunks = 1 (ok)
	 */
	public Entry findById(long id);
	
    /**
	 * findBy       = 0 (trivial)
	 * operator &   = +1
	 * id           = +1
	 * language     = +1
	 * total chunks = 3 (ok)
	 */
	public Entry findByIdAndLang(long id, String language);

    /**
	 * findBy       = 0 (trivial)
	 * operator &   = +1
	 * id           = +1
	 * lang         = +1
	 * collection   = +1
	 * total chunks = 4 (ok)
	 */
	public Entry findByIdAndLangAndCollection(long id, String language,String collection);

    /**
	 * findBy       = 0 (trivial)
	 * operator &   = +1
	 * !id          = +2
	 * lang         = +1
	 * collection   = +1
	 * total chunks = 5 (not recallable)
	 */
	public Entry findByIdNotAndLangAndCollection(long id, String language,String collection);

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
	public Entry findByIdNotAndLangAndCollectionAndCategoryInAndDateBefore(long id, String language, String collection, List<String> categories, long page, long size);

	public static class Entry {

	}
}