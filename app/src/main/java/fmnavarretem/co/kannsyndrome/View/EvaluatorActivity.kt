package fmnavarretem.co.kannsyndrome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.widget.ArrayAdapter
import fmnavarretem.co.kannsyndrome.Model.POJO.Symptom
import fmnavarretem.co.kannsyndrome.Model.Persistence.PreferencesManager
import fmnavarretem.co.kannsyndrome.Presenter.EvaluatorPresenter
import fmnavarretem.co.kannsyndrome.Presenter.IEvaluatorPresenter
import fmnavarretem.co.kannsyndrome.View.IEvaluatorView
import kotlinx.android.synthetic.main.activity_evaluator.*

class EvaluatorActivity : AppCompatActivity(), IEvaluatorView {

    val presenter: IEvaluatorPresenter = EvaluatorPresenter(view = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluator)

        /**
         * Set List To Headache Spinner
         * */
        val headacheAdapter = ArrayAdapter.createFromResource(this,R.array.yes_not_array,android.R.layout.simple_spinner_item)
        headacheAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerHeadache.adapter = headacheAdapter

        /**
         * Set List To Gender Spinner
         * */
        val genderAdapter = ArrayAdapter.createFromResource(this,R.array.gender_array,android.R.layout.simple_spinner_item)
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = genderAdapter

        /**
         * Set List To Alcohol Spinner
         * */
        val alcoholAdapter = ArrayAdapter.createFromResource(this,R.array.yes_not_array,android.R.layout.simple_spinner_item)
        alcoholAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAlcohol.adapter = alcoholAdapter

        btEvaluator.setOnClickListener { onEvaluatorClick() }

    }

    /**
     * Click on the button to make the evaluation
     * */
    private fun onEvaluatorClick(){
        val symptom = Symptom(headache = spinnerHeadache.selectedItem.toString(),
                age = etAge.text.toString(),
                gender = spinnerGender.selectedItem.toString(),
                alcohol = spinnerAlcohol.selectedItem.toString())
        presenter.doEvaluation(symptom = symptom)
    }

    /**
     * here is the response of the process
     * */
    override fun notifyEvaluationDone(symptom: Symptom) {
        tvResult.text = symptom.result
        /**
         * Save on preferences
         * */
//        val symptoms = PreferencesManager.getSymptoms(this)
//        symptoms?.let {
//            it.add(symptom)
//            PreferencesManager.setSymptoms(symptoms = it,context = this)
//        }?: kotlin.run {
//            val firtsSymptoms = arrayListOf<Symptom>()
//            firtsSymptoms.add(symptom)
//            PreferencesManager.setSymptoms(symptoms = firtsSymptoms,context = this)
//        }
    }

    override fun notifyBadAge() {
        etAge.error = resources.getString(R.string.bad_age)
    }

}
