package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart
{//the ShoppingCart
    //key：商品编号 value:商品条目
    private Map<Integer,ProductItem> map=new LinkedHashMap<Integer,ProductItem>();

    public void addProduct(Product p)
    {//add item
        int productId=p.getProductId();
        if(map.containsKey(productId))
        {
            ProductItem productItem=map.get(productId);
            productItem.setCount(productItem.getCount()+1);
        }else
        {
            map.put(productId, new ProductItem(p,1));
        }
    }

    public void showAll()
    {//view order infor
        Collection<ProductItem> productItems = map.values();
        Iterator<ProductItem> iterator = productItems.iterator();
        while(iterator.hasNext())
        {
            ProductItem productItem = iterator.next();
            Product product = productItem.getProduct();
            System.out.println("ProductId："+product.getProductId()+",ItemName："
            +product.getProductName()+",itemPrice："+product.getPrice()+",Quantity："+productItem.getCount()
            +",totalPrice："+productItem.totalMoney());
            // total price of items in the cart
        }
    }
    public boolean deleteProduct(int productId)
    {//deleteitem
        if(map.containsKey(productId))
        {
            map.remove(productId);
            return true;
        }
        return false;
    }
    public boolean modifyProduct(int productId,int count)
    {//修改
        if(map.containsKey(productId)){
            if(count>=1){
                ProductItem productItem = map.get(productId);
                productItem.setCount(count);
                return true;
            }else if(count==0)
            {//delete this item
                deleteProduct(productId);
                return true;
            }
        }
        return false;
    }

    public void clearCart()
    {//empty the chart
        map.clear();
    }

    public double totalAllMoney()
    {//totalP
        double total=0;
        Collection<ProductItem> productItems = map.values();
        Iterator<ProductItem> iterator = productItems.iterator();
        while(iterator.hasNext())
        {
            ProductItem productItem = iterator.next();
            double money=productItem.totalMoney();
            total+=money;
        }
        return total;
    }
}
