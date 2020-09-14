// Generated by view binder compiler. Do not edit!
package com.example.goods.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import com.example.goods.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityToolBarBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final DrawerLayout dl;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView toolbarTv;

  private ActivityToolBarBinding(@NonNull DrawerLayout rootView, @NonNull DrawerLayout dl,
      @NonNull Toolbar toolbar, @NonNull TextView toolbarTv) {
    this.rootView = rootView;
    this.dl = dl;
    this.toolbar = toolbar;
    this.toolbarTv = toolbarTv;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityToolBarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityToolBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tool_bar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityToolBarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      DrawerLayout dl = (DrawerLayout) rootView;

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.toolbar_tv;
      TextView toolbarTv = rootView.findViewById(id);
      if (toolbarTv == null) {
        break missingId;
      }

      return new ActivityToolBarBinding((DrawerLayout) rootView, dl, toolbar, toolbarTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
