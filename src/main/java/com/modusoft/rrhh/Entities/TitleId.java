package com.modusoft.rrhh.Entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class TitleId implements Serializable {
    private Integer emp_no;
    private String title;

    @Override
    public boolean equals(Object o){
         if(this==o) return true;
         if(!(o instanceof TitleId)) return false;
         TitleId that = (TitleId) o;
         return Objects.equals((title, that.title) && Object.equals(emp_no, that.emp_no));
    }

    @Override
    public int hashCode(){
            return Objects.hash(emp_no, title);
    }
}
