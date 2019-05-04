package com.cydia.etcdkeeper.service;

import com.cydia.etcdkeeper.entity.ServerConfig;
import com.cydia.etcdkeeper.enums.ResultCodes;
import com.cydia.etcdkeeper.exception.EtcdKeeperException;
import com.cydia.etcdkeeper.repository.ServerConfigRepository;
import com.cydia.etcdkeeper.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


/**
 * etcd service bean factory
 */
@Service
public class EtcdServiceFactory {

    @Autowired
    private ServerConfigRepository serverConfigRepository;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * get etcd service by server config id
     * @param serverId server id
     * @return EtcdService bean
     */
    public EtcdService getService(int serverId){
        ServerConfig serverConfig = serverConfigRepository.getOne(serverId);
        if(serverConfig==null){
            throw new EtcdKeeperException(String.format("cann't find server config with id: %s",serverId));
        }

        return getService(serverConfig.getApiVersion());
    }


    /**
     * get etcd service by api version
     * @param apiVersion Etcd api version
     * @return EtcdService bean
     */
    public EtcdService getService(String apiVersion){
        String beanName = "EtcdV"+ apiVersion;
        EtcdService service = applicationContext.getBean( beanName,EtcdService.class);

        if(service==null){
            throw new EtcdKeeperException(String.format("cann't find EtcdService with bean name: %s",beanName));
        }

        return service;
    }
}
