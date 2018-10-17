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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (!categoryId.equals(category.categoryId)) return false;
        if (supCategoryId != null ? !supCategoryId.equals(category.supCategoryId) : category.supCategoryId != null)
            return false;
        if (!categoryName.equals(category.categoryName)) return false;
        return preview != null ? preview.equals(category.preview) : category.preview == null;
    }

    @Override
    public int hashCode() {
        int result = categoryId.hashCode();
        result = 31 * result + (supCategoryId != null ? supCategoryId.hashCode() : 0);
        result = 31 * result + categoryName.hashCode();
        result = 31 * result + (preview != null ? preview.hashCode() : 0);
        return result;
    }
}