package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_ALL = "select product_id as id, display_info_id, name,description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date\n"
			+ "from (select display_info.id as display_info_id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email\n"
			+ "from display_info join display_info_image on (display_info.id = display_info_image.display_info_id)) as A join (select product.id as id, name, description, content, event, create_date, modify_date\n"
			+ "from product join category on (product.category_id = category.id)) as B on (A.product_id = B.id)";
}
