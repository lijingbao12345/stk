// Generated by view binder compiler. Do not edit!
package com.example.goods.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.goods.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutTitleBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView ivLeft;

  @NonNull
  public final ImageView ivRight;

  @NonNull
  public final LinearLayout layoutLeft;

  @NonNull
  public final LinearLayout layoutRight;

  @NonNull
  public final RelativeLayout layoutTitle;

  @NonNull
  public final TextView tvLeft;

  @NonNull
  public final TextView tvRight;

  @NonNull
  public final ImageView tvRightImg;

  @NonNull
  public final TextView tvTitle;

  private LayoutTitleBinding(@NonNull RelativeLayout rootView, @NonNull ImageView ivLeft,
      @NonNull ImageView ivRight, @NonNull LinearLayout layoutLeft,
      @NonNull LinearLayout layoutRight, @NonNull RelativeLayout layoutTitle,
      @NonNull TextView tvLeft, @NonNull TextView tvRight, @NonNull ImageView tvRightImg,
      @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.ivLeft = ivLeft;
    this.ivRight = ivRight;
    this.layoutLeft = layoutLeft;
    this.layoutRight = layoutRight;
    this.layoutTitle = layoutTitle;
    this.tvLeft = tvLeft;
    this.tvRight = tvRight;
    this.tvRightImg = tvRightImg;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutTitleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutTitleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_title, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutTitleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_left;
      ImageView ivLeft = rootView.findViewById(id);
      if (ivLeft == null) {
        break missingId;
      }

      id = R.id.iv_right;
      ImageView ivRight = rootView.findViewById(id);
      if (ivRight == null) {
        break missingId;
      }

      id = R.id.layout_left;
      LinearLayout layoutLeft = rootView.findViewById(id);
      if (layoutLeft == null) {
        break missingId;
      }

      id = R.id.layout_right;
      LinearLayout layoutRight = rootView.findViewById(id);
      if (layoutRight == null) {
        break missingId;
      }

      RelativeLayout layoutTitle = (RelativeLayout) rootView;

      id = R.id.tv_left;
      TextView tvLeft = rootView.findViewById(id);
      if (tvLeft == null) {
        break missingId;
      }

      id = R.id.tv_right;
      TextView tvRight = rootView.findViewById(id);
      if (tvRight == null) {
        break missingId;
      }

      id = R.id.tv_right_img;
      ImageView tvRightImg = rootView.findViewById(id);
      if (tvRightImg == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = rootView.findViewById(id);
      if (tvTitle == null) {
        break missingId;
      }

      return new LayoutTitleBinding((RelativeLayout) rootView, ivLeft, ivRight, layoutLeft,
          layoutRight, layoutTitle, tvLeft, tvRight, tvRightImg, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
