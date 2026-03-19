package de.sduni.jets.model.v20;

import java.util.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationProgramStatic_Options extends KnxBase {
    @JacksonXmlProperty(isAttribute = true, localName = "PreferPartialDownloadIfApplicationLoaded")
    private boolean PreferPartialDownloadIfApplicationLoaded;
    @JacksonXmlProperty(isAttribute = true, localName = "EasyCtrlModeModeStyleEmptyGroupComTables")
    private boolean EasyCtrlModeModeStyleEmptyGroupComTables;
    @JacksonXmlProperty(isAttribute = true, localName = "SetObjectTableLengthAlwaysToOne")
    private boolean SetObjectTableLengthAlwaysToOne;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterEncoding")
    private String TextParameterEncoding;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterEncodingSelector")
    private String TextParameterEncodingSelector;
    @JacksonXmlProperty(isAttribute = true, localName = "TextParameterZeroTerminate")
    private boolean TextParameterZeroTerminate;
    @JacksonXmlProperty(isAttribute = true, localName = "ParameterByteOrder")
    private String ParameterByteOrder;
    @JacksonXmlProperty(isAttribute = true, localName = "PartialDownloadOnlyVisibleParameters")
    private boolean PartialDownloadOnlyVisibleParameters;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyNoPartialDownload")
    private boolean LegacyNoPartialDownload;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyNoMemoryVerifyMode")
    private boolean LegacyNoMemoryVerifyMode;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyNoOptimisticWrite")
    private boolean LegacyNoOptimisticWrite;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyDoNotReportPropertyWriteErrors")
    private boolean LegacyDoNotReportPropertyWriteErrors;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyNoBackgroundDownload")
    private boolean LegacyNoBackgroundDownload;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyDoNotCheckManufacturerId")
    private boolean LegacyDoNotCheckManufacturerId;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyAlwaysReloadAppIfCoVisibilityChanged")
    private boolean LegacyAlwaysReloadAppIfCoVisibilityChanged;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyNeverReloadAppIfCoVisibilityChanged")
    private boolean LegacyNeverReloadAppIfCoVisibilityChanged;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyDoNotSupportUndoDelete")
    private boolean LegacyDoNotSupportUndoDelete;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyAllowPartialDownloadIfAp2Mismatch")
    private boolean LegacyAllowPartialDownloadIfAp2Mismatch;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyKeepObjectTableGaps")
    private boolean LegacyKeepObjectTableGaps;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyProxyCommunicationObjects")
    private boolean LegacyProxyCommunicationObjects;
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceInfoIgnoreRunState")
    private boolean DeviceInfoIgnoreRunState;
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceInfoIgnoreLoadedState")
    private boolean DeviceInfoIgnoreLoadedState;
    @JacksonXmlProperty(isAttribute = true, localName = "DeviceCompareAllowCompatibleManufacturerId")
    private boolean DeviceCompareAllowCompatibleManufacturerId;
    @JacksonXmlProperty(isAttribute = true, localName = "LineCoupler0912NewProgrammingStyle")
    private boolean LineCoupler0912NewProgrammingStyle;
    @JacksonXmlProperty(isAttribute = true, localName = "MaxRoutingApduLength")
    private long MaxRoutingApduLength;
    @JacksonXmlProperty(isAttribute = true, localName = "Comparable")
    private boolean Comparable;
    @JacksonXmlProperty(isAttribute = true, localName = "Reconstructable")
    private boolean Reconstructable;
    @JacksonXmlProperty(isAttribute = true, localName = "DownloadInvisibleParameters")
    private String DownloadInvisibleParameters;
    @JacksonXmlProperty(isAttribute = true, localName = "SupportsExtendedMemoryServices")
    private boolean SupportsExtendedMemoryServices;
    @JacksonXmlProperty(isAttribute = true, localName = "SupportsExtendedPropertyServices")
    private boolean SupportsExtendedPropertyServices;
    @JacksonXmlProperty(isAttribute = true, localName = "SupportsIpSystemBroadcast")
    private boolean SupportsIpSystemBroadcast;
    @JacksonXmlProperty(isAttribute = true, localName = "NotLoadable")
    private String NotLoadable;
    @JacksonXmlProperty(isAttribute = true, localName = "NotLoadableMessageRef")
    private String NotLoadableMessageRef;
    @JacksonXmlProperty(isAttribute = true, localName = "CustomerAdjustableParameters")
    private String CustomerAdjustableParameters;
    @JacksonXmlProperty(isAttribute = true, localName = "MasterResetOnCRCMismatch")
    private boolean MasterResetOnCRCMismatch;
    @JacksonXmlProperty(isAttribute = true, localName = "PromptBeforeFullDownload")
    private boolean PromptBeforeFullDownload;
    @JacksonXmlProperty(isAttribute = true, localName = "LegacyPatchManufacturerIdInTaskSegment")
    private boolean LegacyPatchManufacturerIdInTaskSegment;

    public boolean getPreferPartialDownloadIfApplicationLoaded() { return PreferPartialDownloadIfApplicationLoaded; }
    public void setPreferPartialDownloadIfApplicationLoaded(boolean value) { this.PreferPartialDownloadIfApplicationLoaded = value; }
    public boolean getEasyCtrlModeModeStyleEmptyGroupComTables() { return EasyCtrlModeModeStyleEmptyGroupComTables; }
    public void setEasyCtrlModeModeStyleEmptyGroupComTables(boolean value) { this.EasyCtrlModeModeStyleEmptyGroupComTables = value; }
    public boolean getSetObjectTableLengthAlwaysToOne() { return SetObjectTableLengthAlwaysToOne; }
    public void setSetObjectTableLengthAlwaysToOne(boolean value) { this.SetObjectTableLengthAlwaysToOne = value; }
    public String getTextParameterEncoding() { return TextParameterEncoding; }
    public void setTextParameterEncoding(String value) { this.TextParameterEncoding = value; }
    public String getTextParameterEncodingSelector() { return TextParameterEncodingSelector; }
    public void setTextParameterEncodingSelector(String value) { this.TextParameterEncodingSelector = value; }
    public boolean getTextParameterZeroTerminate() { return TextParameterZeroTerminate; }
    public void setTextParameterZeroTerminate(boolean value) { this.TextParameterZeroTerminate = value; }
    public String getParameterByteOrder() { return ParameterByteOrder; }
    public void setParameterByteOrder(String value) { this.ParameterByteOrder = value; }
    public boolean getPartialDownloadOnlyVisibleParameters() { return PartialDownloadOnlyVisibleParameters; }
    public void setPartialDownloadOnlyVisibleParameters(boolean value) { this.PartialDownloadOnlyVisibleParameters = value; }
    public boolean getLegacyNoPartialDownload() { return LegacyNoPartialDownload; }
    public void setLegacyNoPartialDownload(boolean value) { this.LegacyNoPartialDownload = value; }
    public boolean getLegacyNoMemoryVerifyMode() { return LegacyNoMemoryVerifyMode; }
    public void setLegacyNoMemoryVerifyMode(boolean value) { this.LegacyNoMemoryVerifyMode = value; }
    public boolean getLegacyNoOptimisticWrite() { return LegacyNoOptimisticWrite; }
    public void setLegacyNoOptimisticWrite(boolean value) { this.LegacyNoOptimisticWrite = value; }
    public boolean getLegacyDoNotReportPropertyWriteErrors() { return LegacyDoNotReportPropertyWriteErrors; }
    public void setLegacyDoNotReportPropertyWriteErrors(boolean value) { this.LegacyDoNotReportPropertyWriteErrors = value; }
    public boolean getLegacyNoBackgroundDownload() { return LegacyNoBackgroundDownload; }
    public void setLegacyNoBackgroundDownload(boolean value) { this.LegacyNoBackgroundDownload = value; }
    public boolean getLegacyDoNotCheckManufacturerId() { return LegacyDoNotCheckManufacturerId; }
    public void setLegacyDoNotCheckManufacturerId(boolean value) { this.LegacyDoNotCheckManufacturerId = value; }
    public boolean getLegacyAlwaysReloadAppIfCoVisibilityChanged() { return LegacyAlwaysReloadAppIfCoVisibilityChanged; }
    public void setLegacyAlwaysReloadAppIfCoVisibilityChanged(boolean value) { this.LegacyAlwaysReloadAppIfCoVisibilityChanged = value; }
    public boolean getLegacyNeverReloadAppIfCoVisibilityChanged() { return LegacyNeverReloadAppIfCoVisibilityChanged; }
    public void setLegacyNeverReloadAppIfCoVisibilityChanged(boolean value) { this.LegacyNeverReloadAppIfCoVisibilityChanged = value; }
    public boolean getLegacyDoNotSupportUndoDelete() { return LegacyDoNotSupportUndoDelete; }
    public void setLegacyDoNotSupportUndoDelete(boolean value) { this.LegacyDoNotSupportUndoDelete = value; }
    public boolean getLegacyAllowPartialDownloadIfAp2Mismatch() { return LegacyAllowPartialDownloadIfAp2Mismatch; }
    public void setLegacyAllowPartialDownloadIfAp2Mismatch(boolean value) { this.LegacyAllowPartialDownloadIfAp2Mismatch = value; }
    public boolean getLegacyKeepObjectTableGaps() { return LegacyKeepObjectTableGaps; }
    public void setLegacyKeepObjectTableGaps(boolean value) { this.LegacyKeepObjectTableGaps = value; }
    public boolean getLegacyProxyCommunicationObjects() { return LegacyProxyCommunicationObjects; }
    public void setLegacyProxyCommunicationObjects(boolean value) { this.LegacyProxyCommunicationObjects = value; }
    public boolean getDeviceInfoIgnoreRunState() { return DeviceInfoIgnoreRunState; }
    public void setDeviceInfoIgnoreRunState(boolean value) { this.DeviceInfoIgnoreRunState = value; }
    public boolean getDeviceInfoIgnoreLoadedState() { return DeviceInfoIgnoreLoadedState; }
    public void setDeviceInfoIgnoreLoadedState(boolean value) { this.DeviceInfoIgnoreLoadedState = value; }
    public boolean getDeviceCompareAllowCompatibleManufacturerId() { return DeviceCompareAllowCompatibleManufacturerId; }
    public void setDeviceCompareAllowCompatibleManufacturerId(boolean value) { this.DeviceCompareAllowCompatibleManufacturerId = value; }
    public boolean getLineCoupler0912NewProgrammingStyle() { return LineCoupler0912NewProgrammingStyle; }
    public void setLineCoupler0912NewProgrammingStyle(boolean value) { this.LineCoupler0912NewProgrammingStyle = value; }
    public long getMaxRoutingApduLength() { return MaxRoutingApduLength; }
    public void setMaxRoutingApduLength(long value) { this.MaxRoutingApduLength = value; }
    public boolean getComparable() { return Comparable; }
    public void setComparable(boolean value) { this.Comparable = value; }
    public boolean getReconstructable() { return Reconstructable; }
    public void setReconstructable(boolean value) { this.Reconstructable = value; }
    public String getDownloadInvisibleParameters() { return DownloadInvisibleParameters; }
    public void setDownloadInvisibleParameters(String value) { this.DownloadInvisibleParameters = value; }
    public boolean getSupportsExtendedMemoryServices() { return SupportsExtendedMemoryServices; }
    public void setSupportsExtendedMemoryServices(boolean value) { this.SupportsExtendedMemoryServices = value; }
    public boolean getSupportsExtendedPropertyServices() { return SupportsExtendedPropertyServices; }
    public void setSupportsExtendedPropertyServices(boolean value) { this.SupportsExtendedPropertyServices = value; }
    public boolean getSupportsIpSystemBroadcast() { return SupportsIpSystemBroadcast; }
    public void setSupportsIpSystemBroadcast(boolean value) { this.SupportsIpSystemBroadcast = value; }
    public String getNotLoadable() { return NotLoadable; }
    public void setNotLoadable(String value) { this.NotLoadable = value; }
    public String getNotLoadableMessageRef() { return NotLoadableMessageRef; }
    public void setNotLoadableMessageRef(String value) { this.NotLoadableMessageRef = value; }
    public String getCustomerAdjustableParameters() { return CustomerAdjustableParameters; }
    public void setCustomerAdjustableParameters(String value) { this.CustomerAdjustableParameters = value; }
    public boolean getMasterResetOnCRCMismatch() { return MasterResetOnCRCMismatch; }
    public void setMasterResetOnCRCMismatch(boolean value) { this.MasterResetOnCRCMismatch = value; }
    public boolean getPromptBeforeFullDownload() { return PromptBeforeFullDownload; }
    public void setPromptBeforeFullDownload(boolean value) { this.PromptBeforeFullDownload = value; }
    public boolean getLegacyPatchManufacturerIdInTaskSegment() { return LegacyPatchManufacturerIdInTaskSegment; }
    public void setLegacyPatchManufacturerIdInTaskSegment(boolean value) { this.LegacyPatchManufacturerIdInTaskSegment = value; }
}