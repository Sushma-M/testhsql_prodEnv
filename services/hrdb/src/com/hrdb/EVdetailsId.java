/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.hrdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.Column;
import javax.persistence.Embeddable;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;




/**
 * EVdetailsId generated by hbm2java
 */
@Embeddable
public class EVdetailsId  implements java.io.Serializable
 {


private String firstname;
private String lastname;
private Integer budget;
private String deptcode;

    public EVdetailsId() {
    }




    

    @Column(name="FIRSTNAME")
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    

    @Column(name="LASTNAME")
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    

    @Column(name="BUDGET")
    public Integer getBudget() {
        return this.budget;
    }
    
    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    

    @Column(name="DEPTCODE", length=20)
    public String getDeptcode() {
        return this.deptcode;
    }
    
    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof EVdetailsId) )
		 return false;

		 EVdetailsId that = ( EVdetailsId ) o;

         return ( (this.getFirstname()==that.getFirstname()) || ( this.getFirstname()!=null && that.getFirstname()!=null && this.getFirstname().equals(that.getFirstname()) ) )
 && ( (this.getLastname()==that.getLastname()) || ( this.getLastname()!=null && that.getLastname()!=null && this.getLastname().equals(that.getLastname()) ) )
 && ( (this.getBudget()==that.getBudget()) || ( this.getBudget()!=null && that.getBudget()!=null && this.getBudget().equals(that.getBudget()) ) )
 && ( (this.getDeptcode()==that.getDeptcode()) || ( this.getDeptcode()!=null && that.getDeptcode()!=null && this.getDeptcode().equals(that.getDeptcode()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getFirstname() == null ? 0 : this.getFirstname().hashCode() );
         result = 37 * result + ( getLastname() == null ? 0 : this.getLastname().hashCode() );
         result = 37 * result + ( getBudget() == null ? 0 : this.getBudget().hashCode() );
         result = 37 * result + ( getDeptcode() == null ? 0 : this.getDeptcode().hashCode() );

         return result;
     }


}

