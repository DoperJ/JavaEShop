package top.doperj.product.domain;

public class Category {
    private Integer categoryId;

    private Integer supCategoryId;

    private String categoryName;

    private String preview;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSupCategoryId() {
        return supCategoryId;
    }

    public void setSupCategoryId(Integer supCategoryId) {
        this.supCategoryId = supCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview == null ? null : preview.trim();
    }

    @Override
    public String toString() {
        return "category{" +
                "categoryId=" + categoryId +
                ", supCategoryId=" + supCategoryId +
                ", categoryName='" + categoryName + '\'' +
                ", preview='" + preview + '\'' +
                '}';
    }
}