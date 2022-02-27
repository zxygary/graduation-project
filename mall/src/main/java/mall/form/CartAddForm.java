package mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 添加商品
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    private Boolean selected = true;
}
