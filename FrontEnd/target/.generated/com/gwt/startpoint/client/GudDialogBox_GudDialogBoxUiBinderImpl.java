// .ui.xml template last modified: 1500482453428
package com.gwt.startpoint.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.Widget;

public class GudDialogBox_GudDialogBoxUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.Widget, com.gwt.startpoint.client.GudDialogBox>, com.gwt.startpoint.client.GudDialogBox.GudDialogBoxUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<div align='center'> <span id='{0}'></span> </div>")
    SafeHtml html1(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.Widget createAndBindUi(final com.gwt.startpoint.client.GudDialogBox owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final com.gwt.startpoint.client.GudDialogBox owner;


    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.doClickDelete((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.doClickGet((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    final com.google.gwt.event.dom.client.ClickHandler handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3 = new com.google.gwt.event.dom.client.ClickHandler() {
      public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
        owner.doClickUpdate((com.google.gwt.event.dom.client.ClickEvent) event);
      }
    };

    public Widgets(final com.gwt.startpoint.client.GudDialogBox owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenBundle) GWT.create(com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for style called 0 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenCss_style get_style() {
      return build_style();
    }
    private com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenCss_style build_style() {
      // Creation section.
      final com.gwt.startpoint.client.GudDialogBox_GudDialogBoxUiBinderImpl_GenCss_style style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();

      return style;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.

      {
        // Attach section.
        UiBinderUtil.TempAttachment __attachRecord__ = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());

        get_domId0Element().get();

        // Detach section.
        __attachRecord__.detach();
      }
      f_HTMLPanel1.addAndReplaceElement(get_f_VerticalPanel2(), get_domId0Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId0;
    }

    /**
     * Getter for f_VerticalPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_f_VerticalPanel2() {
      return build_f_VerticalPanel2();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_f_VerticalPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      f_VerticalPanel2.add(get_f_HorizontalPanel3());
      f_VerticalPanel2.add(get_getButton());
      f_VerticalPanel2.add(get_f_HorizontalPanel5());
      f_VerticalPanel2.add(get_f_HorizontalPanel7());
      f_VerticalPanel2.add(get_f_HorizontalPanel9());

      return f_VerticalPanel2;
    }

    /**
     * Getter for f_HorizontalPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel3() {
      return build_f_HorizontalPanel3();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel3.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
      f_HorizontalPanel3.add(get_f_Label4());
      f_HorizontalPanel3.add(get_idTextBox());

      return f_HorizontalPanel3;
    }

    /**
     * Getter for f_Label4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label4() {
      return build_f_Label4();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label4.setText("Id:");

      return f_Label4;
    }

    /**
     * Getter for idTextBox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextBox get_idTextBox() {
      return build_idTextBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_idTextBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox idTextBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.

      this.owner.idTextBox = idTextBox;

      return idTextBox;
    }

    /**
     * Getter for getButton called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Button get_getButton() {
      return build_getButton();
    }
    private com.google.gwt.user.client.ui.Button build_getButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button getButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      getButton.setText("Get");
      getButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames2);

      return getButton;
    }

    /**
     * Getter for f_HorizontalPanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel5() {
      return build_f_HorizontalPanel5();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel5.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
      f_HorizontalPanel5.add(get_f_Label6());
      f_HorizontalPanel5.add(get_nameTextBox());

      return f_HorizontalPanel5;
    }

    /**
     * Getter for f_Label6 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label6() {
      return build_f_Label6();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label6() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label6.setText("Name:");

      return f_Label6;
    }

    /**
     * Getter for nameTextBox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextBox get_nameTextBox() {
      return build_nameTextBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_nameTextBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox nameTextBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.

      this.owner.nameTextBox = nameTextBox;

      return nameTextBox;
    }

    /**
     * Getter for f_HorizontalPanel7 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel7() {
      return build_f_HorizontalPanel7();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel7 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel7.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
      f_HorizontalPanel7.add(get_f_Label8());
      f_HorizontalPanel7.add(get_descriptionTextBox());

      return f_HorizontalPanel7;
    }

    /**
     * Getter for f_Label8 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label8() {
      return build_f_Label8();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label8() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label8 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label8.setText("Description:");

      return f_Label8;
    }

    /**
     * Getter for descriptionTextBox called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextBox get_descriptionTextBox() {
      return build_descriptionTextBox();
    }
    private com.google.gwt.user.client.ui.TextBox build_descriptionTextBox() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox descriptionTextBox = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.

      this.owner.descriptionTextBox = descriptionTextBox;

      return descriptionTextBox;
    }

    /**
     * Getter for f_HorizontalPanel9 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel9() {
      return build_f_HorizontalPanel9();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel9() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel9 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel9.setVerticalAlignment(com.google.gwt.user.client.ui.HasVerticalAlignment.ALIGN_MIDDLE);
      f_HorizontalPanel9.add(get_updateButton());
      f_HorizontalPanel9.add(get_deleteButton());

      return f_HorizontalPanel9;
    }

    /**
     * Getter for updateButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_updateButton() {
      return build_updateButton();
    }
    private com.google.gwt.user.client.ui.Button build_updateButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button updateButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      updateButton.setText("Update");
      updateButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames3);

      return updateButton;
    }

    /**
     * Getter for deleteButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Button get_deleteButton() {
      return build_deleteButton();
    }
    private com.google.gwt.user.client.ui.Button build_deleteButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.Button deleteButton = (com.google.gwt.user.client.ui.Button) GWT.create(com.google.gwt.user.client.ui.Button.class);
      // Setup section.
      deleteButton.setText("Delete");
      deleteButton.addClickHandler(handlerMethodWithNameVeryUnlikelyToCollideWithUserFieldNames1);

      return deleteButton;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.

      return domId0Element;
    }
  }
}
