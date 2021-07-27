package io.lesible.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p> @date: 2021-07-13 17:42</p>
 *
 * @author 何嘉豪
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBatchDecryptParam {

    private List<CipherInfo> cipherInfos;

}
