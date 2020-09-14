// Generated by view binder compiler. Do not edit!
package com.example.goods.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.goods.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemBrandmanufacturerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView itemBrandmanufacturerImg;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  private ItemBrandmanufacturerBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView itemBrandmanufacturerImg, @NonNull TextView textView4,
      @NonNull TextView textView5, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.itemBrandmanufacturerImg = itemBrandmanufacturerImg;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemBrandmanufacturerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemBrandmanufacturerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_brandmanufacturer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemBrandmanufacturerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.item_brandmanufacturer_img;
      ImageView itemBrandmanufacturerImg = rootView.findViewById(id);
      if (itemBrandmanufacturerImg == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = rootView.findViewById(id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = rootView.findViewById(id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = rootView.findViewById(id);
      if (textView6 == null) {
        break missingId;
      }

      return new ItemBrandmanufacturerBinding((ConstraintLayout) rootView, itemBrandmanufacturerImg,
          textView4, textView5, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
