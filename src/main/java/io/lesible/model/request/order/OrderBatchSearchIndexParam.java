package io.lesible.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>  </p>
 * <p> created at 2021-11-11 17:08 by lesible </p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBatchSearchIndexParam {

    private List<EncryptText> plainTextList;

}