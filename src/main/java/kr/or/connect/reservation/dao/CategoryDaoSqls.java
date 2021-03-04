package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_ALL = "select id, name , IFNULL(cnt,0) as count\n"
			+ "from category left join (select category_id, count(*) as cnt\n"
			+ "from display_info join product on (display_info.product_id = product.id)\n"
			+ "group by category_id) as A on (A.category_id = category.id)";
	public static final String GET_COUNT = "select count(*) from category";
}
