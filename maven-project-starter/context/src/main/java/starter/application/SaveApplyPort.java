package starter.application;

import starter.domain.*;

public interface SaveApplyPort {
    void save(CompetitionNewApply newApply);
    void save(ProjectNewApply newApply);
}
