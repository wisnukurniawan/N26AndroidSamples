package de.n26.n26androidsamples.credit.presentation.dashboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.n26.n26androidsamples.base.presentation.recyclerview.DisplayableItem;
import de.n26.n26androidsamples.base.presentation.recyclerview.ViewHolderBinder;
import de.n26.n26androidsamples.base.presentation.recyclerview.ViewHolderFactory;
import de.n26.n26androidsamples.credit.R;

class InRepaymentCardViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView amount;
    private final TextView paidOutDate;
    private final TextView totalRepaid;
    private final TextView nextPaymentLabel;
    private final TextView nextPayment;

    private InRepaymentCardViewHolder(final View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.text_in_repayment_card_title);
        amount = itemView.findViewById(R.id.text_in_repayment_card_amount);
        paidOutDate = itemView.findViewById(R.id.text_in_repayment_card_paid_out_date);
        totalRepaid = itemView.findViewById(R.id.text_in_repayment_card_total_repaid);
        nextPaymentLabel = itemView.findViewById(R.id.text_in_repayment_card_next_payment_label);
        nextPayment = itemView.findViewById(R.id.text_in_repayment_card_next_payment);
    }

    private void bind(@NonNull final InRepaymentCardViewModel viewModel) {
        title.setText(viewModel.title());
        amount.setText(viewModel.formattedAmount());
        paidOutDate.setText(viewModel.formattedPaidOutDate());
        totalRepaid.setText(viewModel.formattedTotalRepaid());
        nextPaymentLabel.setText(viewModel.nextPaymentLabel());
        nextPayment.setText(viewModel.formattedNextPayment());
    }

    static class InRepaymentCardHolderFactory extends ViewHolderFactory {

        InRepaymentCardHolderFactory(@NonNull final Context context) {
            super(context);
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder createViewHolder(@NonNull final ViewGroup parent) {
            return new InRepaymentCardViewHolder(LayoutInflater.from(context)
                                                               .inflate(R.layout.item_credit_dashboard_in_repayment_card, parent, false));
        }
    }

    static class InRepaymentCardHolderBinder implements ViewHolderBinder {

        @Override
        public void bind(@NonNull final RecyclerView.ViewHolder viewHolder, @NonNull final DisplayableItem item) {
            InRepaymentCardViewHolder castedViewHolder = InRepaymentCardViewHolder.class.cast(viewHolder);
            InRepaymentCardViewModel viewModel = InRepaymentCardViewModel.class.cast(item.model());
            castedViewHolder.bind(viewModel);
        }
    }
}