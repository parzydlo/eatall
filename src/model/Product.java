package model;
public class Product
{
    private int productId;// 商品编号
    private String productName;// 商品名称
    private String category;// 商品分类
    private double price;// 单价

    public Product()
    {// 无参构造
        super();
    }

    public Product(int productId, String productName, String category, double price) 
    {
        super();
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public String toString()
    {
        return "Product [productId=" + productId + ", productName="
                + productName + ", category=" + category + ", price=" + price
                + "]";
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

}
