package com.test.amaro.amarotest.presentation.main.filter;


import static com.test.amaro.amarotest.models.ProductComparator.OrderingOptions.ALEATORY;
import static com.test.amaro.amarotest.models.ProductComparator.OrderingOptions.HIGH_ORDERING;
import static com.test.amaro.amarotest.models.ProductComparator.OrderingOptions.LOW_ORDERING;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.test.amaro.amarotest.AmaroApplication;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.dagger.components.DialogFragmentComponent;
import javax.inject.Inject;

public class FilterDialogFragment extends DialogFragment implements FilterContract.FilterView {

    public static final String TAG = FilterDialogFragment.class.getSimpleName();

    DialogFragmentComponent component;

    @Inject
    FilterPresenter presenter;
    private RadioGroup priceOrderingRadioGroup;
    private RadioButton highPriceOrderingRadioGroup;
    private RadioButton lowPriceOrderingRadioGroup;
    private RadioButton aleatoryPriceOrderingRadioGroup;
    private CheckBox promotionCheckBox;

    private boolean hasPreferencesUpdated;

    public FilterDialogFragment() {
        component = AmaroApplication.getApplicationComponent().dialogFragmentComponent();
    }

    public static FilterDialogFragment newInstance() {
        return new FilterDialogFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component.inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_filter, container, false);
        setDialogNoTitle();
        setupPreferencesViews(view);
        return view;
    }


    /**
     *
     * Set no title to current @dialog
     * used for lower android apis don't show a deprecated default dialog title
     *
     */
    private void setDialogNoTitle() {
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
    }

    private void setupPreferencesViews(View view) {
        priceOrderingRadioGroup = view.findViewById(R.id.radioGroup);
        aleatoryPriceOrderingRadioGroup = view
                .findViewById(R.id.aleatory_price_ordering_radio_button);
        highPriceOrderingRadioGroup = view.findViewById(R.id.high_price_ordering_radio_button);
        lowPriceOrderingRadioGroup = view.findViewById(R.id.low_price_ordering_radio_button);
        promotionCheckBox = view.findViewById(R.id.promotion_checkBox);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(this);
        presenter.loadFilterOptions();
        priceOrderingRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                hasPreferencesUpdated = true;
                switch (checkedId) {
                    case R.id.aleatory_price_ordering_radio_button:
                        presenter.updatePriceOrderingFilter(ALEATORY);
                        return;
                    case R.id.high_price_ordering_radio_button:
                        presenter.updatePriceOrderingFilter(HIGH_ORDERING);
                        return;
                    case R.id.low_price_ordering_radio_button:
                        presenter.updatePriceOrderingFilter(LOW_ORDERING);
                        return;
                    default:
                        presenter.updatePriceOrderingFilter(ALEATORY);
                }
            }
        });
        promotionCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.updatePromotionFilter(isChecked);
                hasPreferencesUpdated = true;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        hasPreferencesUpdated = false;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        final Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }

    @Override
    public void showPriceOrderingFilter(int priceOrderingPreference) {
        switch (priceOrderingPreference) {
            case ALEATORY:
                aleatoryPriceOrderingRadioGroup.toggle();
                return;
            case HIGH_ORDERING:
                highPriceOrderingRadioGroup.toggle();
                return;
            case LOW_ORDERING:
                lowPriceOrderingRadioGroup.toggle();
                return;
            default:
                aleatoryPriceOrderingRadioGroup.toggle();
        }
    }

    @Override
    public void showPromotionFilter(boolean showPromotions) {
        promotionCheckBox.setChecked(showPromotions);
    }

    public boolean hasPreferencesUpdated() {
        return hasPreferencesUpdated;
    }
}
