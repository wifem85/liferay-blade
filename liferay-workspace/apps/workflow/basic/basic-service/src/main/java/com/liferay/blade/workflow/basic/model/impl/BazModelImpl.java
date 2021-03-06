/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.blade.workflow.basic.model.impl;

import com.liferay.blade.workflow.basic.model.Baz;
import com.liferay.blade.workflow.basic.model.BazModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Baz service. Represents a row in the &quot;Workflow_Baz&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>BazModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BazImpl}.
 * </p>
 *
 * @author In??cio Nery
 * @see BazImpl
 * @generated
 */
@ProviderType
public class BazModelImpl extends BaseModelImpl<Baz> implements BazModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a baz model instance should use the <code>Baz</code> interface instead.
	 */
	public static final String TABLE_NAME = "Workflow_Baz";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"bazId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bazId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Workflow_Baz (uuid_ VARCHAR(75) null,bazId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Workflow_Baz";

	public static final String ORDER_BY_JPQL = " ORDER BY baz.bazId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Workflow_Baz.bazId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long BAZID_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public BazModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bazId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBazId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bazId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Baz.class;
	}

	@Override
	public String getModelClassName() {
		return Baz.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Baz, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Baz, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Baz, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Baz)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Baz, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Baz, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Baz)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Baz, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Baz, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Baz>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Baz.class.getClassLoader(), Baz.class, ModelWrapper.class);

		try {
			Constructor<Baz> constructor =
				(Constructor<Baz>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Baz, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Baz, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Baz, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Baz, Object>>();
		Map<String, BiConsumer<Baz, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Baz, ?>>();

		attributeGetterFunctions.put("uuid", Baz::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Baz, String>)Baz::setUuid);
		attributeGetterFunctions.put("bazId", Baz::getBazId);
		attributeSetterBiConsumers.put(
			"bazId", (BiConsumer<Baz, Long>)Baz::setBazId);
		attributeGetterFunctions.put("groupId", Baz::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Baz, Long>)Baz::setGroupId);
		attributeGetterFunctions.put("companyId", Baz::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Baz, Long>)Baz::setCompanyId);
		attributeGetterFunctions.put("userId", Baz::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Baz, Long>)Baz::setUserId);
		attributeGetterFunctions.put("userName", Baz::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Baz, String>)Baz::setUserName);
		attributeGetterFunctions.put("createDate", Baz::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Baz, Date>)Baz::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Baz::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Baz, Date>)Baz::setModifiedDate);
		attributeGetterFunctions.put("status", Baz::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Baz, Integer>)Baz::setStatus);
		attributeGetterFunctions.put("statusByUserId", Baz::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId", (BiConsumer<Baz, Long>)Baz::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", Baz::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<Baz, String>)Baz::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", Baz::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<Baz, Date>)Baz::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getBazId() {
		return _bazId;
	}

	@Override
	public void setBazId(long bazId) {
		_bazId = bazId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Baz.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Baz.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Baz toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BazImpl bazImpl = new BazImpl();

		bazImpl.setUuid(getUuid());
		bazImpl.setBazId(getBazId());
		bazImpl.setGroupId(getGroupId());
		bazImpl.setCompanyId(getCompanyId());
		bazImpl.setUserId(getUserId());
		bazImpl.setUserName(getUserName());
		bazImpl.setCreateDate(getCreateDate());
		bazImpl.setModifiedDate(getModifiedDate());
		bazImpl.setStatus(getStatus());
		bazImpl.setStatusByUserId(getStatusByUserId());
		bazImpl.setStatusByUserName(getStatusByUserName());
		bazImpl.setStatusDate(getStatusDate());

		bazImpl.resetOriginalValues();

		return bazImpl;
	}

	@Override
	public int compareTo(Baz baz) {
		long primaryKey = baz.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Baz)) {
			return false;
		}

		Baz baz = (Baz)obj;

		long primaryKey = baz.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		BazModelImpl bazModelImpl = this;

		bazModelImpl._originalUuid = bazModelImpl._uuid;

		bazModelImpl._originalGroupId = bazModelImpl._groupId;

		bazModelImpl._setOriginalGroupId = false;

		bazModelImpl._originalCompanyId = bazModelImpl._companyId;

		bazModelImpl._setOriginalCompanyId = false;

		bazModelImpl._setModifiedDate = false;

		bazModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Baz> toCacheModel() {
		BazCacheModel bazCacheModel = new BazCacheModel();

		bazCacheModel.uuid = getUuid();

		String uuid = bazCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			bazCacheModel.uuid = null;
		}

		bazCacheModel.bazId = getBazId();

		bazCacheModel.groupId = getGroupId();

		bazCacheModel.companyId = getCompanyId();

		bazCacheModel.userId = getUserId();

		bazCacheModel.userName = getUserName();

		String userName = bazCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			bazCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			bazCacheModel.createDate = createDate.getTime();
		}
		else {
			bazCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			bazCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			bazCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		bazCacheModel.status = getStatus();

		bazCacheModel.statusByUserId = getStatusByUserId();

		bazCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = bazCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			bazCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			bazCacheModel.statusDate = statusDate.getTime();
		}
		else {
			bazCacheModel.statusDate = Long.MIN_VALUE;
		}

		return bazCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Baz, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Baz, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Baz, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Baz)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Baz, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Baz, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Baz, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Baz)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Baz>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _bazId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private Baz _escapedModel;

}