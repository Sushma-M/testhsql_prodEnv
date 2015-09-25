/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker-com*/

package com.hrdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;




/**
 * EVdetails generated by hbm2java
 */
@Entity
@Table(name="E_VDETAILS"
    ,schema="PUBLIC"
)
public class EVdetails  implements java.io.Serializable
 {


private EVdetailsId id;

    public EVdetails() {
    }



     @EmbeddedId

    

    @AttributeOverrides( {
        @AttributeOverride(name="firstname", column=@Column(name="FIRSTNAME") ), 
        @AttributeOverride(name="lastname", column=@Column(name="LASTNAME") ), 
        @AttributeOverride(name="budget", column=@Column(name="BUDGET") ), 
        @AttributeOverride(name="deptcode", column=@Column(name="DEPTCODE", length=20) ) } )
    public EVdetailsId getId() {
        return this.id;
    }
    
    public void setId(EVdetailsId id) {
        this.id = id;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof EVdetails) )
		 return false;

		 EVdetails that = ( EVdetails ) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
     }


}
