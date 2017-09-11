package oracle.demo.oow.bd.util;

/**
 * To read/write data from the kv-store you need to construct a {@code Key}
 * object that you would use to execute get/put operations.
 * <p>
 * This class defines all different kind of {@code Key}/s that are used in the
 * application. The general structure to represent the {@code Key} is that the
 * different key components are separated by '/' and the major key components
 * are separated from minor key components by '-'.
 * </p>
 * <p>
 * For example if my major key has two components 'USER', and 'userId' then I
 * will represent them as /USER/userId/ and if the minor key has one component
 * as 'timestamp' then to represent the full key (major & minor) I would use the
 * notation: /USER/userId/-/timestamp/
 * </p>
 *
 */
public class KeyUtil
{
	/*public static void main(String[] args)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		for(Integer id : customerDAO.getAllCustomerId())
		{
			//TableUtils.insertInToCustomerGenres(getCustomerGenresById(id));
			getCustomerGenresMovie(id);
		}
	}*/
	
	/*public static String getCustomerGenresById(int id)
	{
		Table customerTable = BaseDAO.getKVStore().getTableAPI().getTable("CUSTOMER");
		PrimaryKey key = null;
		Table customerGenreTable = customerTable.getChildTable(CustomerDAO.CHILD_TABLE);
		key = customerGenreTable.createPrimaryKey();
		key.put("id", id);
		key.put("cid", id);
		Row row = BaseDAO.getKVStore().getTableAPI().get(key, null);
		return row.toJsonString(true);
	}*/
	
	/*public static void getCustomerGenresMovie(int id)
	{
		Table customerTable = BaseDAO.getKVStore().getTableAPI().getTable("CUSTOMER");
		PrimaryKey key = null;
		Table customerGenreTable = customerTable.getChildTable(CustomerDAO.CUSTOMER_GENRE_MOVIE_TABLE);
		
 		key = customerGenreTable.createPrimaryKey();
 		key.put("id", id);
 		List<Row> rows = BaseDAO.getKVStore().getTableAPI().multiGet(key, null, null);
		for(Row row : rows)
		{
			TableUtils.insertInToCustomerGenreMovie(row.toJsonString(true));
		}
	}*/
}