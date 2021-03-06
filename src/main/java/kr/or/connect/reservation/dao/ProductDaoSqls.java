package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_ALL = "select product_id as id, category_id, display_info_id, name,description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, file_id\n"
			+ "from (select display_info.id as display_info_id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email,file_id\n"
			+ "from display_info join display_info_image on (display_info.id = display_info_image.display_info_id)) as A join (select product.id as id, category_id, name, description, content, event, create_date, modify_date\n"
			+ "from product join category on (product.category_id = category.id)) as B on (A.product_id = B.id)\n"
			+ "limit :start, :limit;";
	
	public static final String GET_COUNT = "select count(*) from product";
	
	public static final String SELECT_BY_ID = "select product_id as id, category_id, display_info_id, name,description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, file_id\n"
			+ "from (select display_info.id as display_info_id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email,file_id\n"
			+ "from display_info join display_info_image on (display_info.id = display_info_image.display_info_id)) as A join (select product.id as id, category_id, name, description, content, event, create_date, modify_date\n"
			+ "from product join category on (product.category_id = category.id)) as B on (A.product_id = B.id)\n"
			+ "where display_info_id = :id;";
	
	public static final String SELECT_IMAGE_BY_ID = "select product_id, product_image_id, type, file_id as file_info_id, file_name, save_file_name, content_type, delete_flag,create_date,modify_date\n"
			+ "from (select B.product_id, product_image.id as product_image_id, type, file_id\n"
			+ "from (select product_id\n"
			+ "from (select *\n"
			+ "from display_info\n"
			+ "where id = :id) as A join product on (A.product_id = product.id)) as B join product_image on (B.product_id = product_image.product_id)) as C join file_info on (file_id = file_info.id);";

	public static final String SELECT_DISPLAY_INFO_IMAGE_BY_ID = "select B.id as id , display_info_id, file_id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date\n"
			+ "from (select *\n"
			+ "from display_info_image\n"
			+ "where display_info_id =:id) as B join file_info on (file_id = file_info.id);";
	
	public static final String SELECT_AVG_SCORE = "select avg(score)\n"
			+ "from(select score\n"
			+ "from reservation_user_comment join reservation_info on (reservation_user_comment.reservation_info_id = reservation_info.id)\n"
			+ "where display_info_id = :id) as A";
	
	public static final String SELECT_PRICE_BY_ID ="select id, B.product_id, price_type_name, price, discount_rate, create_date, modify_date\n"
			+ "from (select product_id\n"
			+ "from (select *\n"
			+ "from display_info\n"
			+ "where id = :id) as A join product on (A.product_id = product.id)\n"
			+ ") as B join (product_price) on( B.product_id = product_price.product_id);";
	
	public static final String SELECT_COMMENT_BY_ID ="select reservation_user_comment.id, product_id, reservation_info_id,score, reservation_email,comment\n"
			+ "from reservation_user_comment join (select reservation_info.id, display_info_id, product_id, reservation_email\n"
			+ "from reservation_info join display_info on (display_info.id = reservation_info.display_info_id)\n"
			+ "where product_id = :id) as A on (reservation_info_id = A.id)\n"
			+ "limit :start, :limit;";
	
	public static final String SELECT_COMMENT_COUNT_BY_ID = "select count(*)\n"
			+ "from (select reservation_info.id, product_id\n"
			+ "from reservation_info join display_info on (reservation_info.display_info_id = display_info.id)\n"
			+ "where product_id = 1) as A join reservation_user_comment on (A.id = reservation_info_id)";

}
