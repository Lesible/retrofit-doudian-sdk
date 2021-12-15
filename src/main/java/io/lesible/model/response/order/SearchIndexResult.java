package io.lesible.model.response.order;

import lombok.Data;

import java.util.List;

@Data
public class SearchIndexResult {

    private CustomErr customErr;

    private List<PlainToEncryptIndex> plainToEncryptIndexList;
}