package fmnavarretem.co.kannsyndrome.Model

import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom
import fmnavarretem.co.kannsyndrome.Presenter.IEvaluatorListener

class EvaluatorBL(val listener: IEvaluatorListener): IEvaluatorBL {
    override fun doEvaluation(symptom: Symptom) {
        var result = 0.0
        if (symptom.headache.equals("SÍ")){
            result += 0.25
        }
        try {
            if (symptom.age.toInt() in 20..30){
                result += 0.25
            }
        }catch (e: Exception){
            listener.onBadAge()
            return
        }

        if (symptom.gender.equals("FEMENINO")){
            result += 0.25
        }
        if (symptom.alcohol.equals("SÍ")){
            result += 0.25
        }
        symptom.result = "${result * 100} %"
        listener.onEvaluationDone(symptom = symptom)
    }
}