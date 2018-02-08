package org.cisiondata.modules.oauth.service.impl;

import javax.annotation.Resource;

import org.cisiondata.modules.abstr.dao.GenericDAO;
import org.cisiondata.modules.abstr.entity.Query;
import org.cisiondata.modules.abstr.service.impl.GenericServiceImpl;
import org.cisiondata.modules.abstr.web.ResultCode;
import org.cisiondata.modules.oauth.dao.ClientDAO;
import org.cisiondata.modules.oauth.entity.Client;
import org.cisiondata.modules.oauth.service.IClientService;
import org.cisiondata.utils.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service("clientService")
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements IClientService {

	@Resource(name = "clientDAO")
	private ClientDAO clientDAO = null;
	
	@Override
	public GenericDAO<Client, Long> obtainDAOInstance() {
		return clientDAO;
	}
	
	@Override
	public Client readClientByClientId(String clientId) throws BusinessException {
		if (null == clientId || "".equals(clientId)) throw new BusinessException(ResultCode.PARAM_NULL);
		Query query = new Query();
		query.addCondition("clientId", clientId);
		Client client = clientDAO.readDataByCondition(query);
		if (null == client) {
			throw new BusinessException("Client不存在!");
		}
		return client;
	}
	
	@SuppressWarnings("unused")
	private String genClientCacheKey(String clientId) {
		return "oauth:c:" + clientId;
	}
	
}
