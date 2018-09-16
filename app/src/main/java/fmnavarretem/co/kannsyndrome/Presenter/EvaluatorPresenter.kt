package fmnavarretem.co.kannsyndrome.Presenter

import fmnavarretem.co.kannsyndrome.Model.EvaluatorBL
import fmnavarretem.co.kannsyndrome.Model.IEvaluatorBL
import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom
import fmnavarretem.co.kannsyndrome.View.IEvaluatorView

class EvaluatorPresenter(val view: IEvaluatorView): IEvaluatorPresenter, IEvaluatorListener {

    val bl: IEvaluatorBL = EvaluatorBL(listener = this)

    /**
     * IEvaluatorPresenter do the process
     * */
    override fun doEvaluation(symptom: Symptom) {
        bl.doEvaluation(symptom = symptom)
    }


    /**
     * IEvaluatorListener is the response of the process
     * */
    override fun onEvaluationDone(symptom: Symptom) {
        view.notifyEvaluationDone(symptom = symptom)
    }

    override fun onBadAge() {
        view.notifyBadAge()
    }

}