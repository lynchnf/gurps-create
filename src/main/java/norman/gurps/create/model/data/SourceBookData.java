package norman.gurps.create.model.data;

import java.util.ArrayList;
import java.util.List;

public class SourceBookData {
    private List<AdvantageData> advantageDataList = new ArrayList<>();
    private List<DisadvantageData> disadvantageDataList = new ArrayList<>();
    private List<SkillData> skillDataList = new ArrayList<>();
    private List<EquipmentData> equipmentDataList = new ArrayList<>();

    public List<AdvantageData> getAdvantageDataList() {
        return advantageDataList;
    }

    public void setAdvantageDataList(List<AdvantageData> advantageDataList) {
        this.advantageDataList = advantageDataList;
    }

    public List<DisadvantageData> getDisadvantageDataList() {
        return disadvantageDataList;
    }

    public void setDisadvantageDataList(List<DisadvantageData> disadvantageDataList) {
        this.disadvantageDataList = disadvantageDataList;
    }

    public List<SkillData> getSkillDataList() {
        return skillDataList;
    }

    public void setSkillDataList(List<SkillData> skillDataList) {
        this.skillDataList = skillDataList;
    }

    public List<EquipmentData> getEquipmentDataList() {
        return equipmentDataList;
    }

    public void setEquipmentDataList(List<EquipmentData> equipmentDataList) {
        this.equipmentDataList = equipmentDataList;
    }
}
