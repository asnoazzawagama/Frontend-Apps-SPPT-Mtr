package com.example.pbb_mataram.ui;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetroModel {

    @SerializedName("nop")
    @Expose
    private String nop;
    @SerializedName("wp_nama")
    @Expose
    private String wpNama;
    @SerializedName("wp_alamat")
    @Expose
    private String wpAlamat;
    @SerializedName("wp_rt")
    @Expose
    private String wpRt;
    @SerializedName("wp_rw")
    @Expose
    private String wpRw;
    @SerializedName("wp_kelurahan")
    @Expose
    private String wpKelurahan;
    @SerializedName("wp_kecamatan")
    @Expose
    private String wpKecamatan;
    @SerializedName("wp_kotakab")
    @Expose
    private String wpKotakab;
    @SerializedName("wp_propinsi")
    @Expose
    private String wpPropinsi;
    @SerializedName("wp_kodepos")
    @Expose
    private String wpKodepos;
    @SerializedName("wp_telepon")
    @Expose
    private String wpTelepon;
    @SerializedName("wp_handphone")
    @Expose
    private String wpHandphone;
    @SerializedName("wp_email")
    @Expose
    private String wpEmail;
    @SerializedName("wp_fax")
    @Expose
    private String wpFax;
    @SerializedName("wp_npwpd")
    @Expose
    private String wpNpwpd;
    @SerializedName("op_alamat")
    @Expose
    private String opAlamat;
    @SerializedName("op_rt")
    @Expose
    private String opRt;
    @SerializedName("op_rw")
    @Expose
    private String opRw;
    @SerializedName("op_kelurahan")
    @Expose
    private String opKelurahan;
    @SerializedName("op_kecamatan")
    @Expose
    private String opKecamatan;
    @SerializedName("op_kotakab")
    @Expose
    private String opKotakab;
    @SerializedName("op_propinsi")
    @Expose
    private String opPropinsi;
    @SerializedName("op_kodepos")
    @Expose
    private String opKodepos;
    @SerializedName("op_luas_bumi")
    @Expose
    private String opLuasBumi;
    @SerializedName("op_luas_bangunan")
    @Expose
    private String opLuasBangunan;
    @SerializedName("op_kelas_bumi")
    @Expose
    private String opKelasBumi;
    @SerializedName("op_kelas_bangunan")
    @Expose
    private String opKelasBangunan;
    @SerializedName("op_njop_bumi")
    @Expose
    private String opNjopBumi;
    @SerializedName("op_njop_bangunan")
    @Expose
    private String opNjopBangunan;
    @SerializedName("op_njop")
    @Expose
    private String opNjop;
    @SerializedName("op_njoptkp")
    @Expose
    private String opNjoptkp;
    @SerializedName("op_njkp")
    @Expose
    private String opNjkp;
    @SerializedName("sppt_tahun_pajak")
    @Expose
    private String spptTahunPajak;
    @SerializedName("sppt_tanggal_terbit")
    @Expose
    private String spptTanggalTerbit;
    @SerializedName("sppt_tanggal_cetak")
    @Expose
    private String spptTanggalCetak;
    @SerializedName("sppt_tanggal_jatuh_tempo")
    @Expose
    private String spptTanggalJatuhTempo;
    @SerializedName("sppt_pbb_terhutang")
    @Expose
    private String spptPbbTerhutang;
    @SerializedName("sppt_pbb_pengurang")
    @Expose
    private String spptPbbPengurang;
    @SerializedName("sppt_pbb_harus_dibayar")
    @Expose
    private String spptPbbHarusDibayar;
    @SerializedName("sppt_tandatangan_nama")
    @Expose
    private String spptTandatanganNama;
    @SerializedName("sppt_tandatangan_nip")
    @Expose
    private String spptTandatanganNip;
    @SerializedName("sppt_cetak_footprint")
    @Expose
    private String spptCetakFootprint;
    @SerializedName("payment_flag")
    @Expose
    private Integer paymentFlag;
    @SerializedName("payment_paid")
    @Expose
    private String paymentPaid;
    @SerializedName("payment_ref_number")
    @Expose
    private String paymentRefNumber;
    @SerializedName("payment_bank_code")
    @Expose
    private String paymentBankCode;
    @SerializedName("payment_sw_refnum")
    @Expose
    private Object paymentSwRefnum;
    @SerializedName("payment_gw_refnum")
    @Expose
    private Object paymentGwRefnum;
    @SerializedName("payment_sw_id")
    @Expose
    private Object paymentSwId;
    @SerializedName("payment_merchant_code")
    @Expose
    private String paymentMerchantCode;
    @SerializedName("pbb_collectible")
    @Expose
    private String pbbCollectible;
    @SerializedName("pbb_denda")
    @Expose
    private String pbbDenda;
    @SerializedName("pbb_admin_gw")
    @Expose
    private String pbbAdminGw;
    @SerializedName("pbb_misc_fee")
    @Expose
    private Object pbbMiscFee;
    @SerializedName("pbb_total_bayar")
    @Expose
    private String pbbTotalBayar;
    @SerializedName("dinas_or_kpp")
    @Expose
    private String dinasOrKpp;
    @SerializedName("op_tarif")
    @Expose
    private String opTarif;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("verification_code")
    @Expose
    private String verificationCode;
    @SerializedName("history_ubah_tgl_bayar")
    @Expose
    private Object historyUbahTglBayar;
    @SerializedName("history_ubah_jml_bayar")
    @Expose
    private Object historyUbahJmlBayar;
    @SerializedName("pemekaran_flag")
    @Expose
    private Object pemekaranFlag;
    @SerializedName("pemekaran_uuid_op")
    @Expose
    private Object pemekaranUuidOp;
    @SerializedName("op_lk")
    @Expose
    private String opLk;

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    public String getWpNama() {
        return wpNama;
    }

    public void setWpNama(String wpNama) {
        this.wpNama = wpNama;
    }

    public String getWpAlamat() {
        return wpAlamat;
    }

    public void setWpAlamat(String wpAlamat) {
        this.wpAlamat = wpAlamat;
    }

    public String getWpRt() {
        return wpRt;
    }

    public void setWpRt(String wpRt) {
        this.wpRt = wpRt;
    }

    public String getWpRw() {
        return wpRw;
    }

    public void setWpRw(String wpRw) {
        this.wpRw = wpRw;
    }

    public String getWpKelurahan() {
        return wpKelurahan;
    }

    public void setWpKelurahan(String wpKelurahan) {
        this.wpKelurahan = wpKelurahan;
    }

    public String getWpKecamatan() {
        return wpKecamatan;
    }

    public void setWpKecamatan(String wpKecamatan) {
        this.wpKecamatan = wpKecamatan;
    }

    public String getWpKotakab() {
        return wpKotakab;
    }

    public void setWpKotakab(String wpKotakab) {
        this.wpKotakab = wpKotakab;
    }

    public String getWpPropinsi() {
        return wpPropinsi;
    }

    public void setWpPropinsi(String wpPropinsi) {
        this.wpPropinsi = wpPropinsi;
    }

    public String getWpKodepos() {
        return wpKodepos;
    }

    public void setWpKodepos(String wpKodepos) {
        this.wpKodepos = wpKodepos;
    }

    public String getWpTelepon() {
        return wpTelepon;
    }

    public void setWpTelepon(String wpTelepon) {
        this.wpTelepon = wpTelepon;
    }

    public String getWpHandphone() {
        return wpHandphone;
    }

    public void setWpHandphone(String wpHandphone) {
        this.wpHandphone = wpHandphone;
    }

    public String getWpEmail() {
        return wpEmail;
    }

    public void setWpEmail(String wpEmail) {
        this.wpEmail = wpEmail;
    }

    public String getWpFax() {
        return wpFax;
    }

    public void setWpFax(String wpFax) {
        this.wpFax = wpFax;
    }

    public String getWpNpwpd() {
        return wpNpwpd;
    }

    public void setWpNpwpd(String wpNpwpd) {
        this.wpNpwpd = wpNpwpd;
    }

    public String getOpAlamat() {
        return opAlamat;
    }

    public void setOpAlamat(String opAlamat) {
        this.opAlamat = opAlamat;
    }

    public String getOpRt() {
        return opRt;
    }

    public void setOpRt(String opRt) {
        this.opRt = opRt;
    }

    public String getOpRw() {
        return opRw;
    }

    public void setOpRw(String opRw) {
        this.opRw = opRw;
    }

    public String getOpKelurahan() {
        return opKelurahan;
    }

    public void setOpKelurahan(String opKelurahan) {
        this.opKelurahan = opKelurahan;
    }

    public String getOpKecamatan() {
        return opKecamatan;
    }

    public void setOpKecamatan(String opKecamatan) {
        this.opKecamatan = opKecamatan;
    }

    public String getOpKotakab() {
        return opKotakab;
    }

    public void setOpKotakab(String opKotakab) {
        this.opKotakab = opKotakab;
    }

    public String getOpPropinsi() {
        return opPropinsi;
    }

    public void setOpPropinsi(String opPropinsi) {
        this.opPropinsi = opPropinsi;
    }

    public String getOpKodepos() {
        return opKodepos;
    }

    public void setOpKodepos(String opKodepos) {
        this.opKodepos = opKodepos;
    }

    public String getOpLuasBumi() {
        return opLuasBumi;
    }

    public void setOpLuasBumi(String opLuasBumi) {
        this.opLuasBumi = opLuasBumi;
    }

    public String getOpLuasBangunan() {
        return opLuasBangunan;
    }

    public void setOpLuasBangunan(String opLuasBangunan) {
        this.opLuasBangunan = opLuasBangunan;
    }

    public String getOpKelasBumi() {
        return opKelasBumi;
    }

    public void setOpKelasBumi(String opKelasBumi) {
        this.opKelasBumi = opKelasBumi;
    }

    public String getOpKelasBangunan() {
        return opKelasBangunan;
    }

    public void setOpKelasBangunan(String opKelasBangunan) {
        this.opKelasBangunan = opKelasBangunan;
    }

    public String getOpNjopBumi() {
        return opNjopBumi;
    }

    public void setOpNjopBumi(String opNjopBumi) {
        this.opNjopBumi = opNjopBumi;
    }

    public String getOpNjopBangunan() {
        return opNjopBangunan;
    }

    public void setOpNjopBangunan(String opNjopBangunan) {
        this.opNjopBangunan = opNjopBangunan;
    }

    public String getOpNjop() {
        return opNjop;
    }

    public void setOpNjop(String opNjop) {
        this.opNjop = opNjop;
    }

    public String getOpNjoptkp() {
        return opNjoptkp;
    }

    public void setOpNjoptkp(String opNjoptkp) {
        this.opNjoptkp = opNjoptkp;
    }

    public String getOpNjkp() {
        return opNjkp;
    }

    public void setOpNjkp(String opNjkp) {
        this.opNjkp = opNjkp;
    }

    public String getSpptTahunPajak() {
        return spptTahunPajak;
    }

    public void setSpptTahunPajak(String spptTahunPajak) {
        this.spptTahunPajak = spptTahunPajak;
    }

    public String getSpptTanggalTerbit() {
        return spptTanggalTerbit;
    }

    public void setSpptTanggalTerbit(String spptTanggalTerbit) {
        this.spptTanggalTerbit = spptTanggalTerbit;
    }

    public String getSpptTanggalCetak() {
        return spptTanggalCetak;
    }

    public void setSpptTanggalCetak(String spptTanggalCetak) {
        this.spptTanggalCetak = spptTanggalCetak;
    }

    public String getSpptTanggalJatuhTempo() {
        return spptTanggalJatuhTempo;
    }

    public void setSpptTanggalJatuhTempo(String spptTanggalJatuhTempo) {
        this.spptTanggalJatuhTempo = spptTanggalJatuhTempo;
    }

    public String getSpptPbbTerhutang() {
        return spptPbbTerhutang;
    }

    public void setSpptPbbTerhutang(String spptPbbTerhutang) {
        this.spptPbbTerhutang = spptPbbTerhutang;
    }

    public String getSpptPbbPengurang() {
        return spptPbbPengurang;
    }

    public void setSpptPbbPengurang(String spptPbbPengurang) {
        this.spptPbbPengurang = spptPbbPengurang;
    }

    public String getSpptPbbHarusDibayar() {
        return spptPbbHarusDibayar;
    }

    public void setSpptPbbHarusDibayar(String spptPbbHarusDibayar) {
        this.spptPbbHarusDibayar = spptPbbHarusDibayar;
    }

    public String getSpptTandatanganNama() {
        return spptTandatanganNama;
    }

    public void setSpptTandatanganNama(String spptTandatanganNama) {
        this.spptTandatanganNama = spptTandatanganNama;
    }

    public String getSpptTandatanganNip() {
        return spptTandatanganNip;
    }

    public void setSpptTandatanganNip(String spptTandatanganNip) {
        this.spptTandatanganNip = spptTandatanganNip;
    }

    public String getSpptCetakFootprint() {
        return spptCetakFootprint;
    }

    public void setSpptCetakFootprint(String spptCetakFootprint) {
        this.spptCetakFootprint = spptCetakFootprint;
    }

    public Integer getPaymentFlag() {
        return paymentFlag;
    }

    public RetroModel setPaymentFlag(Integer paymentFlag) {
        this.paymentFlag = paymentFlag;
        return null;
    }

    public String getPaymentPaid() {
        return paymentPaid;
    }

    public void setPaymentPaid(String paymentPaid) {
        this.paymentPaid = paymentPaid;
    }

    public String getPaymentRefNumber() {
        return paymentRefNumber;
    }

    public void setPaymentRefNumber(String paymentRefNumber) {
        this.paymentRefNumber = paymentRefNumber;
    }

    public String getPaymentBankCode() {
        return paymentBankCode;
    }

    public void setPaymentBankCode(String paymentBankCode) {
        this.paymentBankCode = paymentBankCode;
    }

    public Object getPaymentSwRefnum() {
        return paymentSwRefnum;
    }

    public void setPaymentSwRefnum(Object paymentSwRefnum) {
        this.paymentSwRefnum = paymentSwRefnum;
    }

    public Object getPaymentGwRefnum() {
        return paymentGwRefnum;
    }

    public void setPaymentGwRefnum(Object paymentGwRefnum) {
        this.paymentGwRefnum = paymentGwRefnum;
    }

    public Object getPaymentSwId() {
        return paymentSwId;
    }

    public void setPaymentSwId(Object paymentSwId) {
        this.paymentSwId = paymentSwId;
    }

    public String getPaymentMerchantCode() {
        return paymentMerchantCode;
    }

    public void setPaymentMerchantCode(String paymentMerchantCode) {
        this.paymentMerchantCode = paymentMerchantCode;
    }

    public String getPbbCollectible() {
        return pbbCollectible;
    }

    public void setPbbCollectible(String pbbCollectible) {
        this.pbbCollectible = pbbCollectible;
    }

    public String getPbbDenda() {
        return pbbDenda;
    }

    public void setPbbDenda(String pbbDenda) {
        this.pbbDenda = pbbDenda;
    }

    public String getPbbAdminGw() {
        return pbbAdminGw;
    }

    public void setPbbAdminGw(String pbbAdminGw) {
        this.pbbAdminGw = pbbAdminGw;
    }

    public Object getPbbMiscFee() {
        return pbbMiscFee;
    }

    public void setPbbMiscFee(Object pbbMiscFee) {
        this.pbbMiscFee = pbbMiscFee;
    }

    public String getPbbTotalBayar() {
        return pbbTotalBayar;
    }

    public void setPbbTotalBayar(String pbbTotalBayar) {
        this.pbbTotalBayar = pbbTotalBayar;
    }

    public String getDinasOrKpp() {
        return dinasOrKpp;
    }

    public void setDinasOrKpp(String dinasOrKpp) {
        this.dinasOrKpp = dinasOrKpp;
    }

    public String getOpTarif() {
        return opTarif;
    }

    public void setOpTarif(String opTarif) {
        this.opTarif = opTarif;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Object getHistoryUbahTglBayar() {
        return historyUbahTglBayar;
    }

    public void setHistoryUbahTglBayar(Object historyUbahTglBayar) {
        this.historyUbahTglBayar = historyUbahTglBayar;
    }

    public Object getHistoryUbahJmlBayar() {
        return historyUbahJmlBayar;
    }

    public void setHistoryUbahJmlBayar(Object historyUbahJmlBayar) {
        this.historyUbahJmlBayar = historyUbahJmlBayar;
    }

    public Object getPemekaranFlag() {
        return pemekaranFlag;
    }

    public void setPemekaranFlag(Object pemekaranFlag) {
        this.pemekaranFlag = pemekaranFlag;
    }

    public Object getPemekaranUuidOp() {
        return pemekaranUuidOp;
    }

    public void setPemekaranUuidOp(Object pemekaranUuidOp) {
        this.pemekaranUuidOp = pemekaranUuidOp;
    }

    public String getOpLk() {
        return opLk;
    }

    public void setOpLk(String opLk) {
        this.opLk = opLk;
    }

}