package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	
	public static String SELECT_ALL = "select A.id, product_id, category_id, name as category_name, description,file_id\n"
			+ "from (select promotion.id as id, product.id as product_id, category_id, description, promotion.file_id as file_id\n"
			+ "from promotion join product on (promotion.product_id = product.id)) as A join category on (A.category_id = category.id);";
	
	public static String GET_COUNT = "select count(*) from promotion";
}
