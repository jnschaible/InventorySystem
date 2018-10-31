/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jnsch
 */
public class OutsourcedPart extends Part {
    private String companyName;

    public OutsourcedPart() {
        super();
        this.setCompanyName("New Company");
    }
    
    public OutsourcedPart(String name, double price, int inStock, int min, int max, String companyName) {
        super(name, price, inStock, min, max);
        this.setCompanyName(companyName);
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getCompanyName() {
        return companyName;
    }
}