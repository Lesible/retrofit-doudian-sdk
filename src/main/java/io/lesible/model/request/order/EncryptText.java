package io.lesible.model.request.order;

import io.lesible.model.enumeration.EncryptType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> 原参数 </p>
 * <p> created at 2021-11-11 16:49 by lesible </p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EncryptText {

    private String plainText;

    private EncryptType encryptType;

}
