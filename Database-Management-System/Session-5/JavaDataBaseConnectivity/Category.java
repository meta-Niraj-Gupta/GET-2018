package JavaDataBaseConnectivity;

/**
 * @author Niraj Gupta
 * Class to get or set the fields from the category table in storefront database.
 * It is a simple POJO class containing setters and getters.
 */
public class Category{
	private String parentCategory;
	private int countChildCategory;

	public String getParentCategory(){
		return parentCategory;
	}

	public int getCountChildCategory(){
		return countChildCategory;
	}

	public void setParentCategory(String parentCategory){
		this.parentCategory = parentCategory;
	}

	public void setCountChildCategory(int countChildCategory){
		this.countChildCategory = countChildCategory;
	}

	@Override
	public String toString(){
		return "Category [parentCategory = " + parentCategory
				+ ", countChildCategory = " + countChildCategory + "]";
	}
}
