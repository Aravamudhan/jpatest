@org.hibernate.annotations.FilterDefs({
    @org.hibernate.annotations.FilterDef(
        name = "limitByUserRank",
        parameters = {
            @org.hibernate.annotations.ParamDef(
                name = "currentUserRank", type = "int"
            )
        }
    )
    ,
    @org.hibernate.annotations.FilterDef(
        name = "limitByUserRankDefault",
        defaultCondition=
            ":currentUserRank >= (" +
                    "select u.RANK from FILTERING_DYNAMIC_USER u " +
                    "where u.ID = SELLER_ID" +
                ")",
        parameters = {
            @org.hibernate.annotations.ParamDef(
                name = "currentUserRank", type = "int"
            )
        }
    )
})
package com.amudhan.jpatest.model.filtering.dynamic;