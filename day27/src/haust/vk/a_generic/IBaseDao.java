package haust.vk.a_generic;

/**
 * @author vk
 *
 * 2016年5月11日
 */
public interface IBaseDao<K> {
	void save(K k);
	void update(K k);
}
