package org.hussard.flight.booking.clean.architecture;

public class Layers {
    /*
       Partie Business
        */
    public static final String BUSINESS_ADAPTER_IN ="BUSINESS_PKG_ADAPTER_IN";
    public static final String BUSINESS_ADAPTER_OUT ="BUSINESS_PKG_ADAPTER_OUT";
    public static final String  BUSINESS_SERVICES="BUSINESS_PKG_SERVICES";
    public static final String  BUSINESS_MODEL="BUSINESS_PKG_MODEL";
    /*
    Partie Infrastructure
     */
    public static final String  INFRA_ENTITIES="INFRA_PKG_ENTITIES";
    public static final String  INFRA_SERVICES="INFRA_PKG_SERVICES";
    /*
    Partie Application
     */
    public static final String  APPLICATION_CONTROLLERS="APPLICATION_PKG_CONTROLLERS";
    public static final String  APPLICATION_SERVICES="APPLICATION_PKG_SERVICES";
    public static final String  APPLICATION_DTO="APPLICATION_PKG_DTO";
}
