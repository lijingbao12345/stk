// Generated by view binder compiler. Do not edit!
package com.example.goods.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.goods.R;
import com.sunfusheng.marqueeview.MarqueeView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class VlayoutPaomadengBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MarqueeView marqueeView;

  @NonNull
  public final View separator1;

  @NonNull
  public final View separator2;

  private VlayoutPaomadengBinding(@NonNull LinearLayout rootView, @NonNull MarqueeView marqueeView,
      @NonNull View separator1, @NonNull View separator2) {
    this.rootView = rootView;
    this.marqueeView = marqueeView;
    this.separator1 = separator1;
    this.separator2 = separator2;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static VlayoutPaomadengBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static VlayoutPaomadengBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.vlayout_paomadeng, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static VlayoutPaomadengBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.marqueeView;
      MarqueeView marqueeView = rootView.findViewById(id);
      if (marqueeView == null) {
        break missingId;
      }

      id = R.id.separator1;
      View separator1 = rootView.findViewById(id);
      if (separator1 == null) {
        break missingId;
      }

      id = R.id.separator2;
      View separator2 = rootView.findViewById(id);
      if (separator2 == null) {
        break missingId;
      }

      return new VlayoutPaomadengBinding((LinearLayout) rootView, marqueeView, separator1,
          separator2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}